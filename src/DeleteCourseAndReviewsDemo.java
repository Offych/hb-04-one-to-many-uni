import entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviewsDemo {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
                 Session session = factory.openSession()) {

            //start transaction
            session.beginTransaction();

            //get the course
            Course tempCourse = session.find(Course.class, 10);

            //print the course
            System.out.println("Deleteing the course...");
            System.out.println(tempCourse);
            //print the course reviews
            System.out.println(tempCourse.getReviews());

            //delete the course

            session.delete(tempCourse);

            //commit transaction
            session.getTransaction().commit();
        }
    }
}
