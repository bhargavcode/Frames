const express = require('express');
const fs = require('fs');
const path = require('path');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

// Middleware to parse JSON bodies
app.use(bodyParser.json());

// Endpoint to save the JSON file
app.post('/update-json', (req, res) => {
    const updatedJson = req.body; // The JSON data sent from the client

    const filePath = path.join(__dirname, 'updated_temp.json'); // Save it in the same location

    // Write the JSON to a file
    fs.writeFile(filePath, JSON.stringify(updatedJson, null, 2), (err) => {
        if (err) {
            return res.status(500).json({ error: 'Error saving the file' });
        }
        res.json({ message: 'File saved successfully!' });
    });
});

// Start the server
app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});
