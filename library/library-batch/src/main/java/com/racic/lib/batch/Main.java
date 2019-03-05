package com.racic.lib.batch;


import com.racic.lib.client.BorrowingWeb;
import com.racic.lib.client.BorrowingWs;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        //the definition of the job instance..by pointing to the launchemailjob class (class implementing Job)
        JobDetail sendjob = JobBuilder.newJob(LaunchEmailJob.class)
                .withIdentity("sendjob", "group1").build();


        //using cron expression to specify the times to run the job.here is every 5seconds for test
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("triggersendjob", "group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                .build();

// schedule the job

        try {
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(sendjob, trigger);
            System.out.println("send ok!");

        } catch (SchedulerException e) {
            e.printStackTrace();
        }



       /*final String username = "stherblain.library@gmail.com";
        final String password = "ABC12345BATCHSt.HerBlain";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("stherblain.library@gmail.com"));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("azura_mamoto@yahoo.co.id"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
*/

    }
}
