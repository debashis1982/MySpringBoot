provider "aws" {}
resource "aws_instance" "lab" {
    ami = "ami-1e299d7e"
    instance_type = "t2.micro"
    tags {
        Name = "lab"
    }
}
