## Already bugs or issues in osCommerce

### Bugs

- Add more than 99 to quantity in one item of cart. Field allows you, but really only
99 is allowed.
- A confirmation is not sent to the provided email address.

### Issues

- Some buttons seem not really enabled (Continue or New Customer, Add to Cart, ...) 
- After logoff I can see my previous Shopping Cart

## Injected bugs

- Create account (create_account.php):
    * Use an incorrect email (line 91 commented)
    * Postcode is mandatory field, but it can be entered empty (line 111 commented)
    * Password confirmation can be different (line 164 commented)
    * Gender is saved always like female (line 180 forced to 'f')
    * Date of birth is not saved, it always save current date. (line 181 changed to assignation
    date('m/d/Y'))
    
- Shopping cart:

   * Always shown 1 cart item at top. (includes/header.php)  
   ```
   echo tep_draw_button(HEADER_TITLE_CART_CONTENTS . ($cart->count_contents() > 0 ? ' (' . '1' . ')' : ''), 'cart', tep_href_link(FILENAME_SHOPPING_CART)) .
   ```
  
  * Try to click remove link on my cart contents for one item. It doesn't work.
  ```
  $products_name .= '<br /><br />' . tep_draw_input_field('cart_quantity[]', $products[$i]['quantity'], 'size="4"') . tep_draw_hidden_field('products_id[]', $products[$i]['id']) . tep_draw_button(IMAGE_BUTTON_UPDATE, 'refresh') . '&nbsp;&nbsp;&nbsp;' . TEXT_OR . '<a href="' . tep_href_link(FILENAME_SHOPPING_CART, 'products_id=' . $products[$i]['id'] . '&action=remove_products') . '">' . TEXT_REMOVE . '</a>';
  ```

  * It is shown 0 item. 's' is not shown. (TEXT_DISPLAY_NUMBER_OF_REVIEWS). src/public_html/includes/languages/english/modules/boxes/bm_shopping_cart.php.

- Products review 

  * Rating is save with one minus ($rating-1). (product_reviews_write.php)
  * Changed behaviour to see reviews without approval (and reviews_status = 0). (product_reviews.php)

       
                                                               
    