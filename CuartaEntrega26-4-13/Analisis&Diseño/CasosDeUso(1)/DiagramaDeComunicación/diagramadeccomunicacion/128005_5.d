format 76

classinstance 128005 class_ref 128011 // RestauranteSwing
  name ""   xyz 132 5 2000 life_line_z 2000
classinstance 128133 class_ref 128005 // Inventario
  name ""   xyz 477 7 2000 life_line_z 2000
classinstance 130693 class_ref 128133 // Existencia
  name ""   xyz 728 14 2000 life_line_z 2000
fragment 134149 "opt"
  xyzwh 21 174 0 808 378
end
textcanvas 134277 "[esEditable]"
  xyzwh 55 194 2000 55 14
note 134405 "El proceso de editar se repetira mientra el usuario no seleccione salir"
  xyzwh 25 62 2000 107 63
durationcanvas 128261 classinstance_ref 128005 // :RestauranteSwing
  xyzwh 179 90 2010 11 432
end
durationcanvas 128389 classinstance_ref 128133 // :Inventario
  xyzwh 502 87 2010 11 89
end
durationcanvas 132101 classinstance_ref 128133 // :Inventario
  xyzwh 502 366 2010 11 156
end
durationcanvas 132357 classinstance_ref 130693 // :Existencia
  xyzwh 754 405 2010 11 73
end
durationcanvas 133765 classinstance_ref 128133 // :Inventario
  xyzwh 502 215 2010 11 76
end
msg 128517 synchronous
  from durationcanvas_ref 128261
  to durationcanvas_ref 128389
  yz 90 2015 explicitmsg "recuentoExistencias()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 373 73
msg 131589 return
  from durationcanvas_ref 128389
  to durationcanvas_ref 128261
  yz 154 2015 explicitmsg "Lista<Existencia>"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 395 139
msg 132229 synchronous
  from durationcanvas_ref 128261
  to durationcanvas_ref 132101
  yz 366 2015 explicitmsg "editar(Existencia, Cantidad)"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 353 346
msg 132485 synchronous
  from durationcanvas_ref 132101
  to durationcanvas_ref 132357
  yz 405 2015 explicitmsg "modifica(Cantidad)"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 651 387
msg 132613 return
  from durationcanvas_ref 132357
  to durationcanvas_ref 132101
  yz 467 2015 explicitmsg "OK"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 529 451
msg 132997 return
  from durationcanvas_ref 132101
  to durationcanvas_ref 128261
  yz 511 2015 explicitmsg "OK"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 203 493
msg 133893 synchronous
  from durationcanvas_ref 128261
  to durationcanvas_ref 133765
  yz 216 2015 explicitmsg "sePuedeEditar(Existencia)"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 366 201
msg 134021 return
  from durationcanvas_ref 133765
  to durationcanvas_ref 128261
  yz 280 2015 explicitmsg "OK"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 205 262
line 134533 -_-_
  from ref 134405 z 2001 to point 85 171
  line 134661 z 2001 to ref 134149
end
