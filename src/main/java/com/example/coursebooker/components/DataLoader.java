package com.example.coursebooker.components;

import com.example.coursebooker.models.Booking;
import com.example.coursebooker.models.Course;
import com.example.coursebooker.models.Customer;
import com.example.coursebooker.repositories.BookingRepository;
import com.example.coursebooker.repositories.CourseRepository;
import com.example.coursebooker.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {}

    public void run(ApplicationArguments args) {

        Customer stephen = new Customer("Stephen Herd", "Bathgate", 24);
        customerRepository.save(stephen);

        Course pythonCourse = new Course("Intro to Python", "Edinburgh", 4);
        courseRepository.save(pythonCourse);

        Booking stephenPythonBooking = new Booking("10-10-2020", pythonCourse, stephen);
        bookingRepository.save(stephenPythonBooking);

        Customer ronan = new Customer("Ronan Hughes", "Newry", 27);
        customerRepository.save(ronan);

        Course rubyCourse = new Course("Advanced Ruby", "Glasgow", 5);
        courseRepository.save(rubyCourse);

        Booking ronanRubyBooking = new Booking("20-10-2020", rubyCourse, ronan);
        bookingRepository.save(ronanRubyBooking);

        Customer helena = new Customer("Helena Kolberg", "Tallinn", 28);
        customerRepository.save(helena);

        Course mushroomCourse = new Course("Mushroom Foraging 101", "Edinburgh", 5);
        courseRepository.save(mushroomCourse);

        Booking helenaMushroomBooking = new Booking("15-10-2020", mushroomCourse, helena);
        bookingRepository.save(helenaMushroomBooking);
    }
}
