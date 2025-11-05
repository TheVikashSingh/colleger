<img width="1245" height="751" alt="image" src="https://github.com/user-attachments/assets/aab96b59-3133-4d33-83a3-139ef0e2563c" /># colleger
A portal to manage students, classes, subjects etc. 









Update 09: **COMPLETED CONTINUOUS INTEGRATION** . 
Finally completed the CI part of my colleger-project using github actions. Had to use matrix strategy of github actions to parallely build 5 backend microservices while reducing verbosity. All the 6 microservices are now successfully hosted on docker hub. The working github actions workflow's name is - CI_Pipeline_Matrix_Build.yml
<img width="1377" height="832" alt="image" src="https://github.com/user-attachments/assets/5b471aa0-65c2-4e2e-a9c5-e785efb1d287" />
<img width="1245" height="751" alt="image" src="https://github.com/user-attachments/assets/906c4ef2-732c-4a70-8a4f-7c7171e75f7a" />




Update 08: Successfully pushed two images - one accounts microservice and the other react frontend using github actions workflow to DockeHub. Next I am going to fully push images of all 5 microservices and the frontend to dockerhub using github actions.
<img width="2560" height="1440" alt="image" src="https://github.com/user-attachments/assets/baca63c0-0edf-48ca-89f8-1cb9aeb86f22" />





Update 07: Learnt retagging images and pushed the frontend image to my dockerhub - thevikashpratapsingh through the CLI (after logging in through Personal Access Token of Docker). i learnt that Docker Hub repositories must start with our Docker Hub username. Also Docker Hub doesn’t support nested repositories (slashes after your username). So I created one more image in my local by renaming an existing image colleger-frontend:latest to thevikashpratapsingh/colleger-frontend:v1 . After that I pushed by -> docker push thevikashpratapsingh/colleger-frontend:v1    
<img width="1476" height="1399" alt="image" src="https://github.com/user-attachments/assets/e59cf7f0-1167-4d13-93f7-080b5f94f06f" />


Update 06: Learnt a lot of things in docker-compose.yml. Fixed volume mounting issue in pgsql. Also removed many errors in the compose file. Revised the concepts of docker volumes, docker system prune, docker logs and many more.
**All 11 containers are running successfully** . 
This compose file as of now generates 11 containers - 5 microservices + 5 microservices' db + 1 react frontend
<img width="2560" height="1440" alt="image" src="https://github.com/user-attachments/assets/4f6d4883-6c28-4d75-ab1f-867087b34256" />
<img width="2560" height="1440" alt="image" src="https://github.com/user-attachments/assets/8d0d7826-7201-4f07-a751-b7687258fa90" />




Update 05: Except student-service all 4 backend containers, postgres single container and react frontend containers are running successfully. Next step is to docker-compose all of these so that atleast one service keeps running from end to end.
<img width="2560" height="1440" alt="image" src="https://github.com/user-attachments/assets/268b08fd-992c-4791-8678-5e7c38e071d7" />



Update 04: Containers of all services are running now on their respective ports in local hosts(Except for student-service as it requires pgsql db which we will configure later).
(accounts service - 8081, caretaker service - 8082, charity-service - 8083, student-service - 8084, teacher-service - 8085)
<img width="2560" height="1440" alt="image" src="https://github.com/user-attachments/assets/151aa5a7-36ea-4022-9b1f-53e73f823b2a" />





Update 03: Successfully built the first docker image using multi-stage build. Planning to use a distroless image in the final build after majority of development is created.
<img width="1300" height="1377" alt="image" src="https://github.com/user-attachments/assets/e342f2ce-7f12-4221-8328-94e027721ba4" />



Update 02: Added spring profiles in backend and .env in frontend. The application is now ready to dockerize.
<img width="2560" height="1440" alt="image" src="https://github.com/user-attachments/assets/bc2c1647-a72c-4c16-a83d-92bb4fdceea5" />



Update 01: Connected React Frontend with Spring Boot + PostgreSQL backend. A super basic working page is created now. The application is running successfully now.
<img width="2560" height="1440" alt="image" src="https://github.com/user-attachments/assets/a06c4445-fc38-4951-a23c-087974c3f387" />
