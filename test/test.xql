<result>
    { for $a in (for $s in document("test/j_caesar.xml")//ACT
    return $s), $sc in $a/SCENE,	$sp in	$sc/SPEECH
    where	$sp/LINE/text() = "No worthier than the dust!"
    return
        <speaks>{
            <speaker>{$sp/SPEAKER/text()}</speaker>,
            <when>{
                <act>{$a/TITLE/text()}</act>,
                <scene>{$sc/TITLE/text()}</scene>
            }
            </when>
        }
        </speaks>
    }
</result>
