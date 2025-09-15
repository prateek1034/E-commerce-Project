# E-commerce-Project

E-Commerce Web Application
Minimal JSP/Servlets/JDBC e-commerce app with MySQL and Tomcat using MVC.

Features
User: register, login, logout
Catalog: list products, view product details
Cart: add, update, remove
Checkout: place order (mock payment), transactional
Admin: basic product/category management (CRUD)

Tech Stack
Frontend: JSP (JSTL, EL)
Backend: Java Servlets, JDBC
Database: MySQL
Server: Apache Tomcat
Architecture: MVC
Compatibility: Java EE 7 Web (Servlet 3.1, JSP 2.3)

Database (Key Tables)
users, admins
categories, products, product_images
carts, cart_items
orders, order_items, payments
addresses, coupons, reviews, audit_logs

URLs
Public: /, /products, /product?id=
Cart: /cart, /cart/add, /cart/update
Checkout: /checkout, /order/place
User: /user/register, /user/login, /user/logout
Admin: /admin (plus nested CRUD routes)

Non-Functional
Performance: < 2s
Security: prepared statements, CSRF/XSS protection, password hashing
Scalability: connection pooling
Reliability: transaction-safe checkout
Maintainability: MVC
Ops: logging and backups

Setup
Create MySQL DB and user; run schema.sql.
Configure JDBC (DriverManager or JNDI DataSource).
Deploy WAR on Tomcat.
Visit /products, /user/register, /cart, /checkout.

Future Enhancements
Real payment gateway
Shipping API integration
Recommendation engine
Multi-role admin
Analytics dashboard
