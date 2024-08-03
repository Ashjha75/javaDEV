# Spring

- spring will have its own container in jvm which is called as IOC container
- it will used to create the objects and manage the objects by spring

Scope of the object:
- singleton:
  - only one object will be created for the class regardless of the number of requests
  - default scope
  - bean will be created at the time of container creation means no need to call the getBean() method
- prototype:
    - new object will be created for each request we define by use scope="prototype"
    - bean will be created at the time of getBean() method call
  