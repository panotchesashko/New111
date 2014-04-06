/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jamesconfigtest;

/**
 *
 * @author Сашко
 */
public class JamesConfigTest
{
  public static void main(String[] args)
    throws Exception
  {
    // CREATE CLIENT INSTANCES
    MailClient redClient = new MailClient("boreas", "localhost");
    MailClient greenClient = new MailClient("green", "localhost");
    MailClient blueClient = new MailClient("blue", "localhost");
    
    // CLEAR EVERYBODY'S INBOX
    redClient.checkInbox(MailClient.CLEAR_MESSAGES);
    greenClient.checkInbox(MailClient.CLEAR_MESSAGES);
    blueClient.checkInbox(MailClient.CLEAR_MESSAGES);
    Thread.sleep(500); // Let the server catch up
    
    // SEND A COUPLE OF MESSAGES TO BLUE (FROM RED AND GREEN)
    redClient.sendMessage(
      "olehlunin@gmail.com",
      "Good evening",
      "We were working hard, but have confused with configurations((");
    greenClient.sendMessage(
      "blue@localhost",
      "Testing blue from green",
      "This is a test message");
    Thread.sleep(50000); // Let the server catch up
    
    // LIST MESSAGES FOR BLUE (EXPECT MESSAGES FROM RED AND GREEN)
    blueClient.checkInbox(MailClient.SHOW_AND_CLEAR);
  }
}