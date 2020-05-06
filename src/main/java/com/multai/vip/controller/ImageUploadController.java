package com.multai.vip.controller;

import com.multai.vip.bean.ImageModel;
import com.multai.vip.dao.ImageRepository;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = {"image"})
public class ImageUploadController {
  @Autowired
  ImageRepository imageRepository;
  
  @PostMapping({"/upload"}) ///ResponseEntity.BodyBuilder
  public String uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
    ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(), compressBytes(file.getBytes()));
    String[] arrOfStr = img.getName().split("_");
    img.setItemId(Integer.parseInt(arrOfStr[1]));
    img.setName(arrOfStr[2]);
    img.setRestaurantId(Integer.parseInt(arrOfStr[0]));
    this.imageRepository.save(img);
    return "saved";
    //return ResponseEntity.status(HttpStatus.OK);
  }
  
  
  @GetMapping(path = {"/get/{itemId}"})
  public ImageModel getImage(@PathVariable("itemId") int itemId) throws IOException {
    Optional<ImageModel> retrievedImage = this.imageRepository.findByItemId(itemId);
    ImageModel img = new ImageModel(((ImageModel)retrievedImage.get()).getName(), ((ImageModel)retrievedImage.get()).getType(), decompressBytes(((ImageModel)retrievedImage.get()).getPicByte()));
    return img;
  }
  
  @GetMapping(path = {"/getAll"})
  public List<ImageModel> getImage() throws IOException {
    List<ImageModel> imageList = new ArrayList<>();
    List<ImageModel> imageList2 = new ArrayList<>();
    imageList = this.imageRepository.findAll();
    for (ImageModel image : imageList) {
      ImageModel retrievedImage = image;
      ImageModel img = new ImageModel(retrievedImage.getItemId(), retrievedImage.getName(), retrievedImage.getType(), decompressBytes(retrievedImage.getPicByte()));
      imageList2.add(img);
    } 
    return imageList2;
  }
  
  @GetMapping(path = {"/getByRestId/{restaurantId}"})
  public List<ImageModel> getImageByRestId(@PathVariable("restaurantId") int restaurantId) throws IOException {
	  List<ImageModel> imageList = new ArrayList<>();
	    List<ImageModel> imageList2 = new ArrayList<>();
	    imageList = this.imageRepository.findByRestaurantId(restaurantId);
	    for (ImageModel image : imageList) {
	      ImageModel retrievedImage = image;
	      ImageModel img = new ImageModel(retrievedImage.getItemId(), retrievedImage.getName(), retrievedImage.getType(), decompressBytes(retrievedImage.getPicByte()));
	      imageList2.add(img);
	    } 
	    return imageList2;
  }
  
  public static byte[] compressBytes(byte[] data) {
    Deflater deflater = new Deflater();
    deflater.setInput(data);
    deflater.finish();
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] buffer = new byte[1024];
    while (!deflater.finished()) {
      int count = deflater.deflate(buffer);
      outputStream.write(buffer, 0, count);
    } 
    try {
      outputStream.close();
    } catch (IOException iOException) {}
    System.out.println("Compressed Image Byte Size - " + (outputStream.toByteArray()).length);
    return outputStream.toByteArray();
  }
  
  public static byte[] decompressBytes(byte[] data) {
    Inflater inflater = new Inflater();
    inflater.setInput(data);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] buffer = new byte[1024];
    try {
      while (!inflater.finished()) {
        int count = inflater.inflate(buffer);
        outputStream.write(buffer, 0, count);
      } 
      outputStream.close();
    } catch (IOException iOException) {
    
    } catch (DataFormatException dataFormatException) {}
    return outputStream.toByteArray();
  }
  
}
