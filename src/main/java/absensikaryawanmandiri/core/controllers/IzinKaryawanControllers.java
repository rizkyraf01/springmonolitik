package absensikaryawanmandiri.core.controllers;

import absensikaryawanmandiri.core.models.entity.absensi_karyawan;
import absensikaryawanmandiri.core.models.entity.izin_karyawan;
import absensikaryawanmandiri.core.services.IzinKaryawanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class IzinKaryawanControllers {

    @Autowired
    private IzinKaryawanServices izinKaryawanServices;

    @GetMapping("/izinkaryawan")
    public String izinKaryawan(Model model){
        model.addAttribute("izinkaryawan", izinKaryawanServices.findAll());
        return "pages/tables/table-izin";
    }

    @GetMapping("/add/izin")
    public String add(Model model){
        model.addAttribute("addIzin", new izin_karyawan());
        return "addizin";
    }

    @PostMapping("/save/izin")
    public  String save(@ModelAttribute izin_karyawan addHadir , RedirectAttributes redirAttrs){
        izin_karyawan izin_karyawans=izinKaryawanServices.addIzin(addHadir);

        if(izin_karyawans != null){
            redirAttrs.addFlashAttribute("Success", "Register Successfully");
//            System.out.println("Izin Successfully");
        } else {
            redirAttrs.addFlashAttribute("Error", "Failed to Register please try again");
//            System.out.println("Failed to Izin please try again");
        }


        izinKaryawanServices.addIzin(addHadir);
        return "redirect:/add/izin";
    }
}
