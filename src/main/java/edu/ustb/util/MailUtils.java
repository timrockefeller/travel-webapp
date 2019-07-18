package edu.ustb.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 发邮件工具类
 */
public final class MailUtils {
    private static final String USER = "XCYZC999@163.com"; // 发件人称号，同邮箱地址
    private static final String PASSWORD = "shouquanma1";

    /**
     *
     * @param to    收件人邮箱
     * @param text  邮件正文
     * @param title 标题
     */
    /* 发送验证信息的邮件 */
    // public static boolean sendMail(String to, String text, String title){
    // try {
    // final Properties props = new Properties();
    // props.put("mail.smtp.auth", "true");
    // props.put("mail.smtp.host", "smtp.163.com");

    // // 发件人的账号
    // props.put("mail.user", USER);
    // //发件人的密码
    // props.put("mail.password", PASSWORD);

    // // 构建授权信息，用于进行SMTP进行身份验证
    // Authenticator authenticator = new Authenticator() {
    // @Override
    // protected PasswordAuthentication getPasswordAuthentication() {
    // // 用户名、密码
    // String userName = props.getProperty("mail.user");
    // String password = props.getProperty("mail.password");
    // return new PasswordAuthentication(userName, password);
    // }
    // };
    // // 使用环境属性和授权信息，创建邮件会话
    // Session mailSession = Session.getInstance(props, authenticator);
    // // 创建邮件消息
    // MimeMessage message = new MimeMessage(mailSession);
    // // 设置发件人
    // String username = props.getProperty("mail.user");
    // InternetAddress form = new InternetAddress(username);
    // message.setFrom(form);

    // // 设置收件人
    // InternetAddress toAddress = new InternetAddress(to);
    // message.setRecipient(Message.RecipientType.TO, toAddress);

    // // 设置邮件标题
    // message.setSubject(title);

    // // 设置邮件的内容体
    // message.setContent(text, "text/html;charset=UTF-8");
    // // 发送邮件
    // Transport.send(message);
    // return true;
    // }catch (Exception e){
    // e.printStackTrace();
    // }
    // return false;
    // }
    public static boolean sendMail(String to, String text, String title) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.163.com");// 指定邮件的发送服务器地址
            // props.put("mail.smtp.auth", "true");//服务器是否要验证用户的身份信息
            Session session = Session.getInstance(props);// 得到Session
            session.setDebug(true);// 代表启用debug模式，可以在控制台输出smtp协议应答的过程
            // 创建一个MimeMessage格式的邮件
            MimeMessage message = new MimeMessage(session);
            // 设置发送者 密码:520520cjc
            Address fromAddress = new InternetAddress("xcyzc999@163.com");// 邮件地址
            message.setFrom(fromAddress);// 设置发送的邮件地址
            // 设置接收者
            Address toAddress = new InternetAddress(to);// 邮件地址
            message.setRecipient(RecipientType.TO, toAddress);// 设置接收者的地址
            // 设置邮件的主题
            message.setSubject(title);
            // 设置邮件的内容
            message.setText(text);
            // 保存邮件
            message.saveChanges();
            // 得到发送邮件的火箭
            Transport transport = session.getTransport("smtp");
            // 火箭连接到服务器上pop3授权密码：520520cjc
            transport.connect("smtp.163.com", "xcyzc999", "shouquanma1");
            // 火箭点火，发送
            transport.sendMessage(message, message.getAllRecipients());
            // 关闭通道
            transport.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws Exception { // 做测试用
        MailUtils.sendMail("bluecats2010@163.com", "你好，这是一封测试邮件，无需回复。", "测试邮件");
        System.out.println("发送成功");
    }

}
