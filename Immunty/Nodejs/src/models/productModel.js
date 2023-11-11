const mongoose = require('mongoose');

const productSchema = new mongoose.Schema({
  productName: String,
  productDescription: String,
  price: {
    type: Number,
    min: 0,
  },
  availabilityStatus: String,
});

const Product = mongoose.model('Product', productSchema);

module.exports = Product;