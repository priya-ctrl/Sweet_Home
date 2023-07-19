// app.js
const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');

const app = express();
const PORT = 3000;

// Connect to MongoDB
mongoose.connect('mongodb://localhost:3000', {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

// Define a Booking schema
const bookingSchema = new mongoose.Schema({
  fromDate: { type: Date, required: true },
  toDate: { type: Date, required: true },
  aadharNumber: { type: String, required: true },
  numOfRooms: { type: Number, required: true },
});

const Booking = mongoose.model('Booking', bookingSchema);

// Middleware to parse JSON request body
app.use(bodyParser.json());

// Endpoint to handle booking requests
app.post('/booking', async (req, res) => {
  try {
    const { fromDate, toDate, aadharNumber, numOfRooms } = req.body;

    // Create a new booking instance
    const newBooking = new Booking({
      fromDate: new Date(fromDate),
      toDate: new Date(toDate),
      aadharNumber,
      numOfRooms,
    });

    // Save the booking to the database
    await newBooking.save();

    // Return a success response
    res.status(201).json({ message: 'Booking saved successfully!' });
  } catch (error) {
    // Handle errors
    res.status(500).json({ error: 'An error occurred while saving the booking.' });
  }
});

// Start the server
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:3000}`);
});
