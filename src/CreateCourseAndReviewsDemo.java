import entity.Course;
import entity.Instructor;
import entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
                 Session session = factory.openSession()) {

            //start transaction
            session.beginTransaction();

            //create a course
            Course tempCourse = new Course("My first course");

            //add some reviews
            tempCourse.addReview(new Review("Great job"));
            tempCourse.addReview(new Review("I hate those courses"));
            tempCourse.addReview(new Review("Cool stuff, already..."));
            //save the course ...and leverage the cascade all
            System.out.println("Saving the course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());


            session.save(tempCourse);


            //commit transaction
            session.getTransaction().commit();
        }
    }
}
