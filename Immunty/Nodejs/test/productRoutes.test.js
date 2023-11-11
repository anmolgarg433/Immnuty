import { use, expect as _expect, request } from 'chai';
import chaiHttp from 'chai-http';
import app from '../app'; // Assuming your main Express app file is app.js

use(chaiHttp);
const expect = _expect;

describe('Product Routes', () => {
    it('should get all products', (done) => {
        request(app)
            .get('/products')
            .end((err, res) => {
                expect(res).to.have.status(200);
                expect(res.body).to.be.an('array');
                // Add more assertions based on the expected behavior of your endpoint
                done();
            });
    });

    // Add more tests for other routes
});