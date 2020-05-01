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

  * If -1 is set in one item, all items are removed!

- Products review 

  * Rating is save with one minus ($rating-1). (product_reviews_write.php)
  * Changed behaviour to see reviews without approval (and reviews_status = 0). (product_reviews.php)

- Currency

  * Changed right symbol of row EUR at currencies table
  * Not working exchange rate         
                                                               
- Texts (admin/includes/languages/english.php)    
  * Displaying 1 to n (of 1 products) (instead of M)
  
- Account. Go to account. The title says 'Mi cuenta'.
- Header
  * Cart Contentzs
  

- Shopping cart box (/public_html/includes/modules/boxes/bm_shopping_cart.php)
  * Total price not computed correctly with all decimals
   src/public_html/includes/classes/shopping_cart.php, 
   $this->total += $currencies->calculate_price($products_price, $products_tax, $qty);
   
- Product listing (/public_html/includes/modules/product_listing.php)
 * Sort product by name (DVD Movies > Action)
       src/public_html/includes/functions/general.php
       Line 896: $sort_prefix = '<a href="' . tep_href_link($PHP_SELF, tep_get_all_get_params(array('page', 'info', 'sort')) . 'page=1&sort=' . $colnum . ($sortby == $colnum . 'a' ? 'd' : 'a')) . '" title="' . tep_output_string(TEXT_SORT_PRODUCTS . ($sortby == $colnum . 'd' || substr($sortby, 0, 1) != $colnum ? TEXT_ASCENDINGLY : TEXT_DESCENDINGLY) . TEXT_BY . $heading) . '" class="productListing-heading">' ;
   



