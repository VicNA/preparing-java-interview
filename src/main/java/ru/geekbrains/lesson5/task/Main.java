package ru.geekbrains.lesson5.task;

import org.hibernate.Session;
import ru.geekbrains.lesson5.task.dao.EntityDao;
import ru.geekbrains.lesson5.task.entity.Student;
import ru.geekbrains.lesson5.task.utils.HibernateUtil;

public class Main {

    public static void main(String[] args) {
        try {
            EntityDao entityDao = new EntityDao(HibernateUtil.getSessionFactory());

            // Добавление 1000 записей в таблицу students
            generatePersistEntities();

            // Выборка всех записей
            System.out.println("Количество записей в таблице students: "
                    + entityDao.findAll(Student.class).size());

            // Выборка одной записи
            Student student = entityDao.find(Student.class,1000L);
            System.out.println(student);

            // Добавление новой записи
            student = new Student();
            student.setName("NewStudent-1");
            student.setMark(6);
            entityDao.save(student);
            System.out.println(entityDao.find(Student.class, 1001L));

            // Обновление записи
            student.setName("UpdateStudent-1");
            System.out.println(entityDao.update(student));

            // Удаление записи
            entityDao.delete(student);
            System.out.println(entityDao.findAll(Student.class).size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.close();
        }
    }

    public static void generatePersistEntities() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            for (int i = 0; i < 1000; i++) {
                Student student = new Student();
                student.setName("Student-" + (i + 1));
                student.setMark((i % 5) + 1);
                session.persist(student);
            }
            session.getTransaction().commit();
        }
    }
}
