package ajbc.patterns.factory.simple;

import ajbc.patterns.factory.simple.NotificationFactory.Channel;

public class Runner {
	public static void main(String[] args)
    {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification(Channel.SMS);
        notification.notifyUser();
    }
}
