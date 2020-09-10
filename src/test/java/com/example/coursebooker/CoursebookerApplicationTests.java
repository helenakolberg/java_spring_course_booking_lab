package com.example.coursebooker;

import com.example.coursebooker.models.Booking;
import com.example.coursebooker.models.Course;
import com.example.coursebooker.models.Customer;
import com.example.coursebooker.repositories.BookingRepository;
import com.example.coursebooker.repositories.CourseRepository;
import com.example.coursebooker.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CoursebookerApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCourseByRating() {
		List<Course> foundCourses = courseRepository.findByRating(4);
		assertEquals(1, foundCourses.size());
	}

	@Test
	public void canFindCustomersByCourseName() {
		List<Customer> foundCustomers = customerRepository.findByBookingsCourseName("Mushroom Foraging 101");
		assertEquals("Helena Kolberg", foundCustomers.get(0).getName());
	}

	@Test
	public void canFindCoursesByCustomerName() {
		List<Course> foundCourses = courseRepository.findByBookingsCustomerName("Helena Kolberg");
		assertEquals("Mushroom Foraging 101", foundCourses.get(0).getName());
	}

	@Test
	public void canFindBookingsByDate() {
		List<Booking> foundBookings = bookingRepository.findByDate("10-10-2020");
		assertEquals(1, foundBookings.size());
	}

}
