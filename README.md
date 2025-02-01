docker build -t credit-score-service:latest .
minikube docker-env
eval $(minikube -p minikube docker-env)
docker build -t credit-scoring-service:latest .
kubectl apply -f deployment.yaml

minikube ip