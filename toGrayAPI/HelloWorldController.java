package com.example.hello_world;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static com.example.hello_world.togray.imageGray.toGRay;


@RestController
public class HelloWorldController {

    @GetMapping({"/"})
    public String helloWorld()
    {
        return  "Hello World";
    }
    @PostMapping(
            value = "/",
            consumes = {MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_JPEG_VALUE},
            produces = {MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_JPEG_VALUE}
    )
    public byte[] NtoRgb(@RequestBody byte[] image){
        byte[] GrayImage;
        try {
            GrayImage = toGRay(image);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return GrayImage;
    }
}
