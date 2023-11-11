import Product, { find } from '../models/productModel';
import Product from '../models/productModel';

//all product operation
exports.getAllProducts = async (req, res) => {
    try {
      const { name, minPrice, maxPrice } = req.query;
  
      let filter = {};
      
      // Add filters based on query parameters
      if (name) {
        filter.productName = { $regex: new RegExp(name, 'i') }; // Case-insensitive name search
      }
  
      if (minPrice !== undefined && maxPrice !== undefined) {
        filter.price = { $gte: minPrice, $lte: maxPrice };
      } else if (minPrice !== undefined) {
        filter.price = { $gte: minPrice };
      } else if (maxPrice !== undefined) {
        filter.price = { $lte: maxPrice };
      }
  
      const products = await Product.find(filter);
      res.json(products);
    } catch (error) {
      console.error(error);
      res.status(500).json({ error: 'Internal Server Error' });
    }
  };

//create operation
export async function createProduct(req, res) {
  try {
    const { productName, productDescription, price, availabilityStatus } = req.body;

    // Validate required fields
    if (!productName || !productDescription || !price || !availabilityStatus) {
      return res.status(400).json({ error: 'All fields are required.' });
    }

    // Validate positive price
    if (price <= 0) {
      return res.status(400).json({ error: 'Price must be a positive value.' });
    }

    const newProduct = new Product({
      productName,
      productDescription,
      price,
      availabilityStatus,
    });

    const savedProduct = await newProduct.save();
    res.status(201).json(savedProduct);
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Internal Server Error' });
  }
}

//read operation
exports.getAllProducts = async (req, res) => {
  try {
    const products = await Product.find();
    res.json(products);
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Internal Server Error' });
  }
};

exports.getProductById = async (req, res) => {
  try {
    const { product_id } = req.params;
    const product = await Product.findById(product_id);

    if (!product) {
      return res.status(404).json({ error: 'Product not found' });
    }

    res.json(product);
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Internal Server Error' });
  }
};

//update operation
exports.updateProduct = async (req, res) => {
    try {
        const { product_id } = req.params;
        const { productName, productDescription, price, availabilityStatus } = req.body;
  
      // Validate positive price
        if (price <= 0) {
            return res.status(400).json({ error: 'Price must be a positive value.' });
        }
  
        const updatedProduct = await Product.findByIdAndUpdate(
            product_id,
        { productName, productDescription, price, availabilityStatus },
        { new: true }
        );
  
        if (!updatedProduct) {
            return res.status(404).json({ error: 'Product not found' });
        }
  
        res.json(updatedProduct);
    } catch (error) {
      console.error(error);
      res.status(500).json({ error: 'Internal Server Error' });
    }
};

//delete operation
exports.deleteProduct = async (req, res) => {
    try {
      const { product_id } = req.params;
      const deletedProduct = await Product.findByIdAndDelete(product_id);
  
      if (!deletedProduct) {
        return res.status(404).json({ error: 'Product not found' });
      }
  
      res.json({ message: 'Product deleted successfully' });
    } catch (error) {
      console.error(error);
      res.status(500).json({ error: 'Internal Server Error' });
    }
  };