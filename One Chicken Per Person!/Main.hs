main = do
  contents <- getContents
  putStrLn . calculateChicken . toInt $ words contents

calculateChicken :: [Int] -> String
calculateChicken (p:q:empty)
  | (p - q) == 1 = "Dr. Chaz needs 1 more piece of chicken!"
  | p > q = "Dr. Chaz needs " ++ (show (p -q)) ++ " more pieces of chicken!"-- More people than chicken
  | (q - p) == 1 = "Dr. Chaz will have 1 piece of chicken left over!"
  | otherwise = "Dr. Chaz will have " ++ (show (q - p)) ++ " pieces of chicken left over!"

toInt :: [String] -> [Int]
toInt = map read
