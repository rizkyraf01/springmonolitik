package absensikaryawanmandiri.core.controllers;

import absensikaryawanmandiri.core.models.entity.absensi_karyawan;
import absensikaryawanmandiri.core.models.entity.daftar_karyawan;
import absensikaryawanmandiri.core.services.AbsensiKaryawanServices;
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
public class AbsenControllers {
    @Autowired
    private AbsensiKaryawanServices absensiKaryawanServices;

    // Absen Karyawan
    @GetMapping("/table-absen")
    public String absenlist(Model model){
        model.addAttribute("daftarabsen",absensiKaryawanServices.findAll());
        return "pages/tables/absen-table";
    }

    @GetMapping("/add/absen")
    public String add(Model model){
        model.addAttribute("addAbsensi", new absensi_karyawan());
        return "pages/forms/absen";
    }

    @PostMapping("/save/absen")
    public  String save( @ModelAttribute absensi_karyawan addAbsensis , RedirectAttributes redirAttrs){
        absensi_karyawan absensi_karyawans=absensiKaryawanServices.addAbsensi(addAbsensis);

        if(absensi_karyawans != null){
            redirAttrs.addFlashAttribute("Success", "Register Successfully");
//            System.out.println("Absen Successfully");
        } else {
            redirAttrs.addFlashAttribute("Error", "Failed to Register please try again");
//            System.out.println("Failed to Absen please try again");
        }


        absensiKaryawanServices.addAbsensi(addAbsensis);
        return "redirect:/add/absen";
    }
}
