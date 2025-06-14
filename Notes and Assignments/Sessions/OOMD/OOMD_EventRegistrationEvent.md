## Problem Statement: Local Community Event Registration System

Background:
A small local community center (e.g., "Harmony Hub") frequently organizes various events for its residents, such as workshops (e.g., "Introduction to Pottery"), sports tournaments (e.g., "Badminton Singles"), cultural festivals (e.g., "Annual Spring Fair"), and educational seminars (e.g., "Financial Planning for Seniors"). Currently, event information is posted on a notice board, and registration is done manually at the front desk, often leading to long queues, lost forms, and difficulties in managing participant numbers and payments.

**Core Functionality Requirements:**

1.  **Event Creation & Management:**
   * Authorized staff members (Event Organizers) must be able to create new events.
   * For each event, they need to define:
      * Event Name
      * Description
      * Date and Time (Start and End)
      * Location (e.g., "Main Hall," "Sports Court 3," "Community Garden")
      * Maximum Capacity (number of participants)
      * Registration Deadline
      * Event Type (e.g., Workshop, Sports, Festival, Seminar, etc.)
      * Fee (if any, including currency)
      * Status (e.g., "Upcoming," "Open for Registration," "Registration Closed," "Cancelled," "Completed")
   * Event Organizers should be able to update event details (e.g., change date, increase capacity) and change its status.
   * They should also be able to view a list of all current and past events.

2.  **User Registration & Profile Management:**
   * Any community resident can register as a user of the system.
   * Upon registration, users provide their Name, Email Address, Phone Number, and a secure Password.
   * Users can log in to view and update their profile information.

3.  **Event Browse & Search:**
   * Registered users (and potentially non-registered visitors) can browse available events.
   * They should be able to search for events by name, type, date range, or location.
   * Event details (name, description, dates, location, fee, remaining slots) should be clearly displayed.

4.  **Event Registration:**
   * Registered users can register for events that are "Open for Registration" and have available slots.
   * The system must check if the maximum capacity has been reached before allowing registration.
   * Users should receive a confirmation (e.g., an email notification) upon successful registration.
   * Users should be able to view their list of registered events.
   * Users should be able to cancel their registration for an event, provided the cancellation deadline has not passed.

5.  **Payment Processing (for paid events):**
   * If an event has a fee, the system should integrate with a payment gateway (assume a simplified integration, just record payment status).
   * A registration is only confirmed after successful payment.
   * The system needs to track payment status (e.g., "Pending," "Paid," "Refunded").

6.  **Participant Management (for Event Organizers):**
   * Event Organizers need to view the list of participants registered for each of their events.
   * For each participant, they should see their name, contact details, and payment status.
   * They should be able to mark attendance for participants on the day of the event.

7.  **Notifications:**
   * System should send automated notifications for:
      * Registration confirmation.
      * Event reminders (e.g., 24 hours before the event starts).
      * Event cancellation (to registered participants).
      * Successful payment.


### Analysis
- /


### Questions
1. 

### Classes
1. 
   - Attributes:
   - Behaviors: 

2.
   - Attributes:
   - Behaviors: 


### Enums
1. 