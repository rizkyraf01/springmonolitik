package absensikaryawanmandiri.core.controllers;

import absensikaryawanmandiri.core.models.entity.daftar_karyawan;
import absensikaryawanmandiri.core.services.DaftarKaryawanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("")
public class DaftarKaryawanControllers {

    @Autowired
    private DaftarKaryawanServices daftarKaryawanServices;

    // Daftar karyawan
    @GetMapping
    public String home(Model model){
//        String messages = "WELCOME TO MY SPRING";
//        model.addAttribute("msg", messages);
//        model.addAttribute("daftarkaryawan", daftarKaryawanServices.findAll());
        return "dashboard";
    }

    @GetMapping("/tabel_karyawan")
    public String tabel(Model model){
        model.addAttribute("daftarkaryawan",daftarKaryawanServices.findAll());
        return  "pages/tables/karyawan-table";
    }
    @GetMapping("/form-register-karyawan")
    public String add(Model model){
        model.addAttribute("addKaryawan", new daftar_karyawan());
        return "pages/forms/add_form_register";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute daftar_karyawan addPegawai, RedirectAttributes redirAttrs){
        
        daftar_karyawan daftar_karyawans = daftarKaryawanServices.addKaryawan(addPegawai);
        if(daftar_karyawans != null){
            redirAttrs.addFlashAttribute("Success", "Register Successfully");
        } else {
            redirAttrs.addFlashAttribute("Error", "Failed to Register please try again");
        }
        return "redirect:/form-register-karyawan";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        daftarKaryawanServices.deleteKaryawanById(id);
        return "redirect:/tabel_karyawan";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model){
        model.addAttribute("updateKaryawan", daftarKaryawanServices.karyawanFindById(id));
        return "pages/forms/edit_form_register";
    }

    @PostMapping("/update")
    public String update(daftar_karyawan updatePegawai, Model model){
        daftarKaryawanServices.updateKaryawan(updatePegawai);
        return "redirect:/tabel_karyawan";
    }


}
