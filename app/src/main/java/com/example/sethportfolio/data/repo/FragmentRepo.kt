package com.example.sethportfolio.data.repo

import com.example.sethportfolio.data.model.Graphics

class FragmentRepo() {

    //Variables
    val introString = "Seth Torralba is a Filipino born, Chicago based Mobile Developer and Designer." +
            " He is a double degree holder having a degree in Mutlimedia Arts and Design from De La Salle College of St Benilde" +
            " in the Philippines and a degree in Computer Science from Lewis University from Illinois. He has experience in" +
            " Graphic Design and Advertising with TELUS International Philippines, a local branch of TELUS International and experience in" +
            " IT Project Management with United Airlines."

    //Graphics Fragment =======================================

    fun getGraphics():ArrayList<Graphics> {

        var list:ArrayList<Graphics> = ArrayList()

        //Graphics 1
        list.add(Graphics("https://firebasestorage.googleapis.com/v0/b/sethportfolio-88648.appspot.com/o/graphics_1.jpg?alt=media&token=be0b3612-674e-44cb-baa2-5571ffd3d6b1",
        "Vector Poster", "This was created as a commissioned work in early 2016", "Adobe Illustrator"))

        //Graphics2
        list.add(Graphics("https://firebasestorage.googleapis.com/v0/b/sethportfolio-88648.appspot.com/o/graphics_2.jpg?alt=media&token=9326f3e7-7751-4532-9463-1cd9bcc14f2a",
        "Menu Design","This was a commissioned work for a local business, Healthylicious back in 2014", "PS"))

        //Graphics3
        list.add(Graphics("https://firebasestorage.googleapis.com/v0/b/sethportfolio-88648.appspot.com/o/graphics_3.JPG?alt=media&token=6d3e2e6b-fb84-4361-af7b-bc0fa113b484",
        "Lynda Poster", "This project was created as a partnership between College of Du page and Lynda.com", "PS"))

        //Graphics4
        list.add(Graphics("https://firebasestorage.googleapis.com/v0/b/sethportfolio-88648.appspot.com/o/graphics_4.jpg?alt=media&token=daa3bed5-a833-4dff-93a7-aa3b63bb05e5",
        "Logo Design", "This was a commissioned logo design for the Organization of Social Studies Teachers in the Philippines", "PS"))

        //Graphics5
        list.add(Graphics("https://firebasestorage.googleapis.com/v0/b/sethportfolio-88648.appspot.com/o/graphics_5.jpg?alt=media&token=34da36aa-805d-4b57-87f1-eb51a2f7ec81",
        "TELUS Poster","This was an internal add in TELUS International Philippines", "PS"))

        //Graphics6
        list.add(Graphics("https://firebasestorage.googleapis.com/v0/b/sethportfolio-88648.appspot.com/o/graphics_6.jpg?alt=media&token=1dda89d3-bf43-42f7-9cdf-d65b42cdfea4",
            "TELUS Poster", "This was an internal add promoting healthy eating", "PS"))

        //Graphics7
        list.add(Graphics("https://firebasestorage.googleapis.com/v0/b/sethportfolio-88648.appspot.com/o/graphics_7.jpg?alt=media&token=301f89a3-74f9-4453-a85b-dcf240bc01fb",
        "TELUS Poster","This was an internal add promoting an internal video event","PS"))

        //Graphics8
        list.add(Graphics("https://firebasestorage.googleapis.com/v0/b/sethportfolio-88648.appspot.com/o/graphics_8.jpg?alt=media&token=b79a6f1d-107b-4de0-bd5f-70a6c1cbc3ac",
        "Baby World Packaging","This is a sample packaging design commissioned by BabyWorld Philippines", "AI"))

        //Graphics9
        list.add(Graphics("https://firebasestorage.googleapis.com/v0/b/sethportfolio-88648.appspot.com/o/graphics_9.jpg?alt=media&token=fc86c4a7-9ace-4921-9ffd-d0f43d10be21",
        "Product Design","This is a Product Design Artboard that was commissioned by Jungle Pals Philippines","AI"))

        //Graphics10
        list.add(Graphics("https://firebasestorage.googleapis.com/v0/b/sethportfolio-88648.appspot.com/o/graphics_10.jpg?alt=media&token=d3dc1d7b-872d-4522-9bbd-0c6b18913fe0",
        "Product Design", "This was a Product Design  art board commissioned by BabyFlo Philippines","AI"))
        return list

    }

    //================================================================================



    //Functions

}