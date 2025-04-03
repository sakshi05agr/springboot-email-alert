package com.etl.emailalert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class TransactionPoller {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EmailService emailService;

    private Timestamp lastChecked = Timestamp.valueOf(LocalDateTime.now().minusMinutes(5));

    @Scheduled(fixedRate = 10000) // every 10 seconds
    public void pollDatabase() {
        System.out.println("⏱️ Polling database at: " + LocalDateTime.now());
        String query = "SELECT * FROM customer_transactions WHERE last_updated > ?";

        List<Map<String, Object>> newTransactions = jdbcTemplate.queryForList(query, lastChecked);

        if (!newTransactions.isEmpty()) {
            System.out.println("📥 Found " + newTransactions.size() + " new/updated transaction(s). Sending email(s)...");
            for (Map<String, Object> row : newTransactions) {
                String message = String.format(
                        "🚨 New or Updated Transaction:\nCustomer: %s\nAmount: $%s\nStatus: %s\nModified By: %s",
                        row.get("customer_name"), row.get("amount"), row.get("status"), row.get("modified_by")
                );

                emailService.sendEmail("recipient@example.com", "Transaction Alert", message);
            }

            lastChecked = Timestamp.valueOf(LocalDateTime.now());
        }
        else{
            System.out.println("✅ No new transactions since last check.");
        }
    }
}
