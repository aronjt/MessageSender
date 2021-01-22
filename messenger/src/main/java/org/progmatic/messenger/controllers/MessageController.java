package org.progmatic.messenger.controllers;

import org.progmatic.messenger.model.Message;
import org.progmatic.messenger.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller

public class MessageController {

    private MessageService messageService;
  //  private UserDetailsService userDetailsService;

    @Autowired
    public MessageController(MessageService messageService/*, UserDetailsService userDetailsService*/) {
        this.messageService = messageService;
     //   this.userDetailsService = userDetailsService;
    }


    @GetMapping(value = {"/", "/home"})
    public String test(Model model){
        model.addAttribute("messages", messageService.getMessageList());
        return "HomePage";
    }

    @GetMapping(value = "/newmessage")
    //@PreAuthorize("")
    public String homePage(@ModelAttribute("newmessage") Message m){
        return "NewMessage";
    }

    @GetMapping(value = "/result")
    public String result(Model model, List<Message> searchedMessages) {
        model.addAttribute("messages", searchedMessages);
        return "HomePage";
    }

    @PostMapping(path = "/search")
    public String search(@RequestParam("toSearch") String search, Model model) {
        List<Message> messageStreamFrom = messageService.getMessageList().stream().
                filter(message -> message.getFrom().contains(search)).collect(Collectors.toList());
        model.addAttribute("messages", messageStreamFrom);
        return "HomePage";
    }

    @RequestMapping(path = "/newmessagesend", method = POST)
    public String creatMes(@Valid @ModelAttribute("newmessage") Message m, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "NewMessage";
        }
        messageService.setSenderName(m.getFrom());
        m.setId(messageService.getMessageList().size()+1);
        messageService.addMessage(m);
        model.addAttribute("senderName", messageService.getSenderName());
        return "redirect:/home";
    }

    @PostMapping(path = "sortbyfrom")
    public String sortByFrom(){
        return null;
    }
}
