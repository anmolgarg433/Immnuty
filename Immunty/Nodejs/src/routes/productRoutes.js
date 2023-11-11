import { Router } from 'express';
const router = Router();
import { getAllProducts, getProductById, createProduct, updateProduct, deleteProduct } from '../controllers/productController';

// GET all products with optional filtering
router.get('/products', getAllProducts);

// GET a specific product by ID
router.get('/products/:product_id', getProductById);

// POST create a new product
router.post('/products', createProduct);

// PUT update a specific product by ID
router.put('/products/:product_id', updateProduct);

// DELETE remove a specific product by ID
router.delete('/products/:product_id', deleteProduct);

export default router;
