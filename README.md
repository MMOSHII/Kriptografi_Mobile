# **Kriptografi Monoalphabetic**  
*Aplikasi ini adalah enkripsi kata simpel menjadi sebuah kode.*

## **Daftar Isi**
3. [Cara Kerja](#Cara-Kerja)  


## **Cara Kerja**  
```
Pseudo Code:
FUNCTION Encrypt_Message(code_encrypt_input: STRING, message: STRING)
    DECLARE encrypt_code AS LIST

    FOR EACH character c IN code_encrypt_input DO
        IF c NOT IN encrypt_code AND c IN ALPHABET THEN
            APPEND c TO encrypt_code
        END IF
    END FOR

    FOR EACH character c IN ALPHABET DO
        IF c NOT IN encrypt_code THEN
            APPEND c TO encrypt_code
        END IF
    END FOR

    DECLARE chiper AS STRING
    FOR EACH character c IN message DO
        chiper += encrypt_code[INDEX OF c IN ALPHABET]
    END FOR

    PRINT "Your Chiper Code: " + chiper
    PRINT "Your Encrypt Code: " + JOIN(encrypt_code)

END FUNCTION

FUNCTION Decrypt_Message(decrypt_code: STRING, chiper_msg: STRING)
    DECLARE output_message AS STRING

    FOR EACH character c IN chiper_msg DO
        output_message += ALPHABET[INDEX OF c IN decrypt_code]
    END FOR

    PRINT "Your Output Message: " + output_message

END FUNCTION
``` 
