for /F "tokens=*" %%i IN ('minikube docker-env') do call %%i
START /WAIT C:\java\jdk-17\bin\java.exe -Dmaven.multiModuleProjectDirectory=E:\IRISI\IRISI_semester5\microservices\PROJECTS\e-taxe\eureka-service "-Dmaven.home=C:\Program Files\JetBrains\IntelliJ IDEA 2021.1.1\plugins\maven\lib\maven3" "-Dclassworlds.conf=C:\Program Files\JetBrains\IntelliJ IDEA 2021.1.1\plugins\maven\lib\maven3\bin\m2.conf" "-Dmaven.ext.class.path=C:\Program Files\JetBrains\IntelliJ IDEA 2021.1.1\plugins\maven\lib\maven-event-listener.jar" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2021.1.1\lib\idea_rt.jar=56908:C:\Program Files\JetBrains\IntelliJ IDEA 2021.1.1\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\JetBrains\IntelliJ IDEA 2021.1.1\plugins\maven\lib\maven3\boot\plexus-classworlds-2.6.0.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2021.1.1\plugins\maven\lib\maven3\boot\plexus-classworlds.license" org.codehaus.classworlds.Launcher -Didea.version=2021.1.1 package

kubectl delete -n default deployment eureka
kubectl apply -f ./k8s/config-map.yaml
kubectl apply -f ./k8s/headless-service.yaml
kubectl apply -f ./k8s/eureka-server-deployment.yaml
minikube service eureka-lb