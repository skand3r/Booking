# Booking Website Project (still in work)

This is a Spring project for a booking website where users can search for hotels, view available options, and manage their bookings. Currently, the focus is on hotel bookings, but the project is designed to be extendable to other types of bookings in the future (e.g., plane tickets, concerts, etc.).

## Features Implemented So Far

- **Spring JPA**: Connected to a PostgreSQL database.
- **Sign In and Sign Up Pages**: Basic user authentication with sessions managed using **Spring Security**.
- **Embedded Hotel List**: Hotels are stored in a class as a list (not yet persisted in the database).
- **Search for Hotels**: Users can search for hotels by city or view all available hotels.
- **Basic HTML/CSS Views**: Webpages are created using HTML and CSS (some external contributions).

## Features Yet to Be Done

- Hash user passwords before saving them to the database.
- Allow users to book different types of rooms in a hotel.
- Add a booking management section where users can view, update, or cancel their bookings.
- Create UI for the above functions.
- Extend the project to support other types of bookings (e.g., plane tickets, concert tickets, etc.).

## Technologies Used

- **Java** with Spring Boot
- **Spring JPA** for database interaction
- **Spring Security** for user authentication and session management
- **PostgreSQL** as the database
- **HTML/CSS** for frontend design
