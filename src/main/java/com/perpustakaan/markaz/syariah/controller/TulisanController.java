package com.perpustakaan.markaz.syariah.controller;

import com.perpustakaan.markaz.syariah.domain.Buku;
import com.perpustakaan.markaz.syariah.domain.Tulisan;
import com.perpustakaan.markaz.syariah.service.TulisanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created by rizki on 27/06/15.
 */

@Controller
public class TulisanController {

    @Autowired
    private TulisanService tulisanService;

    @RequestMapping(value = "/newTulisan", method = RequestMethod.GET)
    public String newTulisan(Model model){
        model.addAttribute("tulisan", new Tulisan());
        return "templates/newTulisan";
    }

    @RequestMapping(value = "/newTulisan", method = RequestMethod.POST)
    public String saveFile(MultipartHttpServletRequest request, HttpServletResponse response, @ModelAttribute("tulisan") Tulisan tulisan) throws IOException {

        Iterator<String> iterator = request.getFileNames();
        MultipartFile multipartFile;

        while(iterator.hasNext()){
            multipartFile = request.getFile(iterator.next());
            String root = request.getSession().getServletContext().getRealPath(File.separator);
            File path = new File(root + File.separator + "upload");
            String fileName = UUID.randomUUID().toString() + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
            tulisan.setLogo(fileName);
            tulisanService.save(tulisan);
            if(File.separator.equals("\\")){
                File file = new File("");
                String fileGambar = file.getAbsolutePath() + File.separator + "src" + File.separator + "main" + File.separator + "webapp" + File.separator + "upload" + File.separator;
                FileCopyUtils.copy(multipartFile.getBytes(), new File(fileGambar + fileName));
                System.out.println("Berhasil Upload Windows");
            }else{
                FileCopyUtils.copy(multipartFile.getBytes(), new File(path + File.separator + fileName));
                System.out.println("Berhasil Upload Linux");
            }
        }

        return "redirect:/";
    }

}
