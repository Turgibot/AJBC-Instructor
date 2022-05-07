package ajbc.patterns.factory.simple;


public class NotificationFactory {
	public Notification createNotification(Channel channel)
    {
        if (channel == null )
            return null;
        switch (channel) {
        case SMS:
            return new SMSNotification();
        case EMAIL:
            return new EmailNotification();
        case PUSH:
            return new PushNotification();
        default:
            throw new IllegalArgumentException("Unknown channel "+channel);
        }
    }
	public enum Channel{
		SMS,EMAIL,PUSH
	}
}
