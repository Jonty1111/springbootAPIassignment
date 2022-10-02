Player == Learners

PlayerProfile=Courses

Meaning of above is like that a learners can only have single course

Meaning of @Id annoataion
*************************
The @Idannotation is inherited from javax.persistence.Id， 
indicating the member field below is the primary key of current entity. 
Hence your Hibernate and spring framework as well as you can do some reflect works based on this annotation. 
for details please check javadoc for Id

Meaning of @GeneratedValue annoataion
*************************
The @GeneratedValue annotation is to configure the way of increment of the specified column(field).
For example when using Mysql, you may specify auto_increment in the definition of table to make it self-incremental, 
and then use


***************************8
Learner Table
->Primary Key-> learner_id
->Foreign Key->course_id

Course Table
->Primary Key->course_id
**************************


[https://stackoverflow.com/questions/20603638/what-is-the-use-of-annotations-id-and-generatedvaluestrategy-generationtype]](https://stackoverflow.com/questions/20603638/what-is-the-use-of-annotations-id-and-generatedvaluestrategy-generationtype]