for $s in document("j_caesar.xml")//SPEAKER,
    $a in document("j_caesar.xml")//ACT,
    $sp in $a//SPEAKER,
    $stxt in $s/text()
where $sp eq $s and $stxt = "CAESAR"
return
  <act>
    { $a/TITLE/text()}
  </act>
