format 76

classinstance 128002 class_ref 145413 // RestauranteSwing
 name ""  xyz 44 196 2000
classinstance 128130 class_ref 145797 // VerReserva
 name ""  xyz 237 195 2000
classinstance 128514 class_ref 141957 // GUIController
 name ""  xyz 234 67 2000
classinstance 129026 class_ref 143493 // Restaurante
 name ""  xyz 433 66 2000
classinstance 129410 class_ref 146693 // LibroReservas
 name ""  xyz 428 197 2000
note 129794 "Diagrama de comunicación cancelar reserva"
  xyzwh 402.5 252.5 2000 243 37
linkcanvas 128258
  from ref 128002 z 2001 to ref 128130
dirscanvas 128386 z 1000 linkcanvas_ref 128258
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "1 VerReserva()" xyz 155 176 3000
linkcanvas 128642
  from ref 128130 z 2001 to ref 128514
dirscanvas 128770 z 1000 linkcanvas_ref 128642
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "2 requestRemoveReserva()" xyz 121 136 3000
linkcanvas 129154
  from ref 128514 z 2001 to ref 129026
dirscanvas 129282 z 1000 linkcanvas_ref 129154
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "3 deleteReserva()" xyz 328 47 3000
linkcanvas 129538
  from ref 129026 z 2001 to ref 129410
dirscanvas 129666 z 1000 linkcanvas_ref 129538
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "4 deleteReserva()" xyz 486 137 3000
msgs
  msg operation_ref 159493 // "VerReserva(inout rest : GUIController)"
    forward ranks 1 "1" dirscanvas_ref 128386
    msgs
      msg operation_ref 141442 // "requestRemoveReserva(in name : string, in fecha : string, in comensales : string, in mesas : string)"
	forward ranks 2 "1.1" dirscanvas_ref 128770
	msgs
	  msg operation_ref 141570 // "deleteReserva(in name : string, in fecha : string, in comensales : string, in mesas : string)"
	    forward ranks 3 "1.1.1" dirscanvas_ref 129282
	    msgs
	      msg operation_ref 141698 // "deleteReserva(in name : string, in fecha : string, in comensales : string, in mesas : string)"
		forward ranks 4 "1.1.1.1" dirscanvas_ref 129666
		no_msg
	    msgsend
	msgsend
    msgsend
msgsend
end
