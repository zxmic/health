package com;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

@SuppressWarnings("deprecation")
public class HibernateSessionFactory{

    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
    private static final ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();
    private static final ThreadLocal<Transaction> transactionThreadLocal = new ThreadLocal<Transaction>();
    private static Configuration configuration = new Configuration();   //.configure();
//    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//    SessionFactory SessionFactory = configuration.buildSessionFactory(builder.build());

    private static SessionFactory sessionFactory;
    private static String configFile = CONFIG_FILE_LOCATION;
//    private static Logger logger = Logger.getLogger(HibernateSessionFactory.class);

    static {
        try {
            //		Configuration configuration = new Configuration();
            //		configuration.configure();
            //		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder();
            //		ServiceRegistry serviceRegistry = serviceRegistryBuilder.buildServiceRegistry();
            //		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            System.out.println("静态创建工厂失败");
//            logger.error("buildSessionFactory");
            throw new HibernateException(e);
        }
    }

    private HibernateSessionFactory() {

    }

//    public static Session getSession() throws HibernateException{
//        Session session=(Session)sessionThreadLocal.get();
//        if(session==null||!session.isOpen()){
//            if(sessionFactory==null){
//                rebuildSessionFactory();
//            }
//            session=(sessionFactory!=null)?sessionFactory.openSession():null;
//            sessionThreadLocal.set(session);
//        }
//        return session;
//    }

    public static SessionFactory getSessionFactory() {
        //		// Instead of a static variable, use JNDI:
        //		SessionFactory sessionFactory = null;
        //		try
        //		{
        //			Context context = new InitialContext();
        //			String jndiName = "java:hibernate/HibernateFactory";
        //			sessionFactory = (SessionFactory) context.lookup(jndiName);
        //		}
        //		catch (NamingException ex)
        //		{
        //			throw new InfrastructureException(ex);
        //		}
        //		return sessionFactory;

        return sessionFactory;
    }

    public static void rebuildSessionFactory() {
        //synchronized (sessionFactory) {
            try {
                configuration.configure(configFile);
                sessionFactory = configuration.buildSessionFactory();
            } catch (HibernateException e) {
                System.out.println("重建工厂失败");
//                logger.error("rebuildSessionFactory");
                throw new HibernateException(e);
            }
        //}
    }

    public static Session getSession() {
        Session session = (Session) sessionThreadLocal.get();

        try {
            if (session == null || !session.isOpen()) {
                if (sessionFactory == null) {
                    rebuildSessionFactory();
                }

                session = (sessionFactory != null) ? sessionFactory.openSession() : null;
                sessionThreadLocal.set(session);
            }
        } catch (HibernateException e) {
            System.out.println("getsession失败");
//            logger.error("openSession");
            throw new HibernateException(e);
        }

        return session;
    }

    public static void closeSession() {
        Session session = (Session) sessionThreadLocal.get();
        sessionThreadLocal.set(null);
        try {
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (HibernateException e) {
            System.out.println("closesession失败");
//            logger.error("close");
            throw new HibernateException(e);
        }
    }

    public static void beginTransaction() {
        Transaction transaction = (Transaction) transactionThreadLocal.get();
        try {
            if (transaction == null) {
                transaction = getSession().beginTransaction();
                transactionThreadLocal.set(transaction);
            }
        } catch (HibernateException e) {
            System.out.println("beginTransaction失败");
//            logger.error("beginTransaction");
            throw new HibernateException(e);
        }
    }

    public static void commitTransaction() {
        Transaction transaction = (Transaction) transactionThreadLocal.get();

        try {
            if (transaction != null && !transaction.isActive() && !transaction.getRollbackOnly()) {
                transaction.commit();
            }
            transactionThreadLocal.set(null);
        } catch (HibernateException e) {
            System.out.println("commitTransaction失败");
//            logger.error("commitTransaction");
            throw new HibernateException(e);
        }
    }

    public static void rollbackTransaction() {
        Transaction transaction = (Transaction) transactionThreadLocal.get();
        try {
            transactionThreadLocal.set(null);
            if (transaction != null && !transaction.isActive()&& !transaction.getRollbackOnly()) {
                transaction.rollback();
            }
        } catch (HibernateException e) {
            System.out.println("rollbackTransaction失败");
//            logger.error("rollbackTransaction");
            throw new HibernateException(e);
        } finally {
            closeSession();
        }
    }

    public static void setConfigFile(String configFile) {
        HibernateSessionFactory.configFile = configFile;
        sessionFactory = null;
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

    public static void add(Object entity) {
        try {
            beginTransaction();
            getSession().save(entity);
            commitTransaction();
            rollbackTransaction();
        } catch (HibernateException e) {
            System.out.println("add失败");
//            logger.error("add");
            throw new HibernateException(e);
        }
    }

    public static void update(Object entity) {
        try {
            beginTransaction();
            getSession().update(entity);
            commitTransaction();
            rollbackTransaction();
        } catch (HibernateException e) {
            System.out.println("update失败");
//            logger.error("update");
            throw new HibernateException(e);
        }
    }

    public static void delete(Object entity) {
        try {
            beginTransaction();
            getSession().delete(entity);
            commitTransaction();
            rollbackTransaction();
        } catch (HibernateException e) {
            System.out.println("delete失败");
//            logger.error("delete");
            throw new HibernateException(e);
        }
    }

    public static Object get(Class<?> clazz, Serializable id) {
        Object object = null;
        try {
            object = getSession().get(clazz, id);
        } catch (HibernateException e) {
            System.out.println("get失败");
//            logger.error("get");
            throw new HibernateException(e);
        } finally {
            closeSession();
        }
        return object;
    }
}