provider "aws" {}
resource "aws_instance" "lab" {
    ami = "ami-1e299d7e"
    instance_type = "t2.micro"
    tags {
        Name = "lab"
    }
   key_name = "debashis1982-new"
    provisioner "file" {
      source = "../target/lab-spring-boot-0.1.0.jar"
      destination = "/tmp/lab-spring-boot-0.1.0.jar"
      connection {
            type = "ssh"
            user = "ec2-user"
            private_key = "${file("~/.ssh/debashis1982-new.pem")}"
      }
    }
    provisioner "remote-exec" {
        inline = [
          "sudo yum -y install java-1.8.0",
          "sudo yum -y remove java-1.7.0-openjdk",
          "chmod 755 /tmp/lab-spring-boot-0.1.0.jar",
          "sudo ln -s /tmp/lab-spring-boot-0.1.0.jar /etc/init.d/labjava",
          "sudo service labjava start"
        ]
         connection {
            type = "ssh"
            user = "ec2-user"
            private_key = "${file("~/.ssh/debashis1982-new.pem")}"
         }
    }
}
