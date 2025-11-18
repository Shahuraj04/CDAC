const jwt = require("jsonwebtoken")
const JWT_SECRET = "mysecretkey"

exports.generateToken = (user) => {

    const payload = { id: user.empId, ename: empname, email: email };
    return jwt.sign(payload, JWT_SECRET, { expiresIn: 200000 });

}

exports.authenticateToken = async (req, resp, next) => {
    console.log('validated jwt token')
    const auth = req.headers.authorization;
    if (!auth || !auth.startwith('Bearer ')) {
        resp.status(401).json({ message: 'Missing token' });

    } else {
        const token = auth.split(' ')[1];
        try {
            const payload = jwt.verify(token, JWT_SECRET);
            req.user = payload;
            console.log(req.user)
            next()

        } catch (error) {
            return resp.status(401).json({ message: 'Invalid/Expired token' });x
        }
    }
}