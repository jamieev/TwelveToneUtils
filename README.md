# TwelveToneUtils
Quick tool to generate a twelve tone matrix and Babbitt-stile time-point series.

Prints out a 12 tone matrix and pops up a JMusic window with notated verions of each Babbitt style timepoint series version.

Usage: TwelveTone [options] [integer_pitch_class_1 ... integer_pitch_class_n]

If no integer pitch classes are passed in as arguments then a random 12 note series will be generated.

options: 
<p> -r suppress row output
<p> -m suppress matrix output
<p> -n suppress timepoint notation output
<p> -t suppress timepoing output

NB: for the moment timepoint output only works for 12 note rows, and  modulus is always 12.
