package com.example.myapplication.Repository

import com.example.myapplication.Model.JobModel

class MainRepository {


    val location = listOf("NewYork,USA","LosAngles,USA")
    val category = listOf("all","Accountant","Programmer","Writer","Software Engineer")


    val exambleText:String = "We are searching for talented and motivated this job to join our growing team.In this role ,you will be responsible for this job."


    val items = listOf(
        JobModel(
            "UI Designer",
            "Google",
            "logo1",
            "Full-time",
            "Remote",
            "Internship",
            "New york,USA",
            "\$38k-\$46k",
            "2",
            exambleText,
            exambleText
        ),
        JobModel(
            "Android Developer",
            "Google",
            "logo2",
            "Full-time",
            "Remote",
            "Internship",
            "New york,USA",
            "\$50k-\$95k",
            "2",
            exambleText,
            exambleText
        ),
        JobModel(
            "Cloud Computing",
            "Intel",
            "logo3",
            "Full-time",
            "Remote",
            "Internship",
            "New york,USA",
            "\$38k-\$46k",
            "2",
            exambleText,
            exambleText
        )
    )
}