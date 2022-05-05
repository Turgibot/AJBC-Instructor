package ajbc.patterens.factory.nonono;

import ajbc.patterens.factory.nonono.NotificationFactory.Channel;

public class Runner {
	public static void main(String[] args)
    {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification(Channel.SMS);
        notification.notifyUser();
    }
}
