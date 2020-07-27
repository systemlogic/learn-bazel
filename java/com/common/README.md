# Deployment on kubernete cluster installed on local machine (mini kube, docker for mac)
1. Please run

```
kubectl run push
```
This command will push the compiled artifact on docker
2. To deploy artifact on k8s cluster please run 
```
kubectl run :dev.apply
```

This will create pv and pvc for mysql. Then it will provision the mysql instance with default password as password.

Once the Database is deployed, login to mysql and run the following commands.

```
create databse systemlogic;
use systemlogic;
create table dept(
department varchar(20) NOT NULL, 
DeptDesc VARCHAR(100), 
PRIMARY KEY(department)
);

create table emp(
EmpID int NOT NULL, 
FirstName varchar(20),
LastName varchar(20),
department varchar(20),
PRIMARY KEY (EmpID),
FOREIGN KEY (department) REFERENCES dept(department)
);
```

Meanwhile it will pull down the myapp docker image from dockerhub and deployed on kus
