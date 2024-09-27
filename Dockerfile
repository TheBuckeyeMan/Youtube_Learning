FROM public.ecr.aws/lambda/java:17
COPY target/helloworld-lambda-0.0.1-SNAPSHOT.jar app.jar
CMD ["com.example.helloworld_lambda.LambdaHandler::handleRequest"]