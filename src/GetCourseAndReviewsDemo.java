import entity.Course;
import entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {
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
            System.out.println(tempCourse);
            //print the course reviews
            System.out.println(tempCourse.getReviews());


            //commit transaction
            session.getTransaction().commit();
        }
    }
}
