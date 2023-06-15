# AWS, Docker's Jenkins, Github

1. Create AWS EC2
    1.1 Connect EC2 Instance

2. install docker in AWS EC2
    sudo dnf install docker

    Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?
    > systemctl start docker

    Failed to start docker.service: Access denied
    > sudo systemctl start docker

    sudo docker pull jenkins
    > sudo docker pull jenkins/jenkins

    [aws ec2 public IPv4 address]:8080 connect fail
    > inbounding rule in "add tcp 8080 0.0.0.0/0"

    skip and continue as admin

    system config
    git, Github
    aws ec2 ssh generate
    deploy ssh key in github repo
    jenkins git credentials change

    sudo docker restart jenkins-test

    find init password
    sudo docker exec jenkins-test cat /var/jenkins_home/secrets/initialAdminPassword
